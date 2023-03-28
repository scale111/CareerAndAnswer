<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="评论人ID" prop="commenterId">
        <el-input v-model="queryParams.commenterId" placeholder="请输入评论人ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="评论人昵称" prop="commenterNickname">
        <el-input v-model="queryParams.commenterNickname" placeholder="请输入评论人昵称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
<!--      <el-form-item label="被评论人ID" prop="reviewedId">-->
<!--        <el-input v-model="queryParams.reviewedId" placeholder="请输入被评论人ID" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="被评论人昵称" prop="reviewedNickname">-->
<!--        <el-input v-model="queryParams.reviewedNickname" placeholder="请输入被评论人昵称" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="帖子ID" prop="postId">
        <el-input v-model="queryParams.postId" placeholder="请输入帖子ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
<!--      <el-form-item label="评论等级" prop="level">-->
<!--        <el-input v-model="queryParams.level" placeholder="请输入评论等级" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="评论上级ID" prop="superiorId">-->
<!--        <el-input v-model="queryParams.superiorId" placeholder="请输入评论上级ID" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="评论内容" prop="text">-->
<!--        <el-input v-model="queryParams.text" placeholder="请输入评论内容" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="审核状态" prop="auditStatus">
        <el-select v-model="queryParams.auditStatus" placeholder="请选择审核状态" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.AUDIT_STATUS)"
                       :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
<!--      <el-form-item label="创建时间" prop="createTime">-->
<!--        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"-->
<!--                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['forum:comment:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['forum:comment:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="评论ID" align="center" prop="id" />
      <el-table-column label="评论人ID" align="center" prop="commenterId" />
      <el-table-column label="评论人昵称" align="center" prop="commenterNickname" />
      <el-table-column label="评论人头像" align="center" prop="commenterAvatar" >
        <template slot-scope="scope">
          <img :src="scope.row.commenterAvatar" style="width:100px;height:100px;"/>
        </template>
      </el-table-column>
      <el-table-column label="被评论人ID" align="center" prop="reviewedId" />
      <el-table-column label="被评论人昵称" align="center" prop="reviewedNickname" />

      <el-table-column label="被评论人头像" align="center" prop="reviewedAvatar" >
        <template slot-scope="scope">
          <img :src="scope.row.reviewedAvatar" style="width:100px;height:100px;"/>
        </template>
      </el-table-column>
      <el-table-column label="帖子ID" align="center" prop="postId" />
      <el-table-column label="评论等级" align="center" prop="level" />
      <el-table-column label="评论上级ID" align="center" prop="superiorId" />
      <el-table-column label="评论内容" align="center" prop="text" />
      <el-table-column label="审核状态" align="center" prop="auditStatus">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.AUDIT_STATUS" :value="scope.row.auditStatus" />
        </template>
      </el-table-column>
<!--      <el-table-column label="创建时间" align="center" prop="createTime" width="180">-->
<!--        <template v-slot="scope">-->
<!--          <span>{{ parseTime(scope.row.createTime) }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['forum:comment:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['forum:comment:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="评论人ID" prop="commenterId">-->
<!--          <el-input v-model="form.commenterId" placeholder="请输入评论人ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="评论人昵称" prop="commenterNickname">-->
<!--          <el-input v-model="form.commenterNickname" placeholder="请输入评论人昵称" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="评论人头像">-->
<!--          <imageUpload v-model="form.commenterAvatar"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="被评论人ID" prop="reviewedId">-->
<!--          <el-input v-model="form.reviewedId" placeholder="请输入被评论人ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="被评论人昵称" prop="reviewedNickname">-->
<!--          <el-input v-model="form.reviewedNickname" placeholder="请输入被评论人昵称" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="被评论人头像">-->
<!--          <imageUpload v-model="form.reviewedAvatar"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="帖子ID" prop="postId">-->
<!--          <el-input v-model="form.postId" placeholder="请输入帖子ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="评论等级" prop="level">-->
<!--          <el-input v-model="form.level" placeholder="请输入评论等级" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="评论上级ID" prop="superiorId">-->
<!--          <el-input v-model="form.superiorId" placeholder="请输入评论上级ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="评论内容" prop="text">-->
<!--          <el-input v-model="form.text" placeholder="请输入评论内容" />-->
<!--        </el-form-item>-->
        <el-form-item label="审核状态" prop="auditStatus">
          <el-select v-model="form.auditStatus" placeholder="请选择审核状态">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.AUDIT_STATUS)"
                       :key="parseInt(dict.value)" :label="dict.label" :value="parseInt(dict.value)" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { createComment, updateComment, deleteComment, getComment, getCommentPage, exportCommentExcel } from "@/api/forum/comment";
import ImageUpload from '@/components/ImageUpload';

export default {
  name: "Comment",
  components: {
    ImageUpload,
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 评论列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        commenterId: null,
        commenterNickname: null,
        commenterAvatar: null,
        reviewedId: null,
        reviewedNickname: null,
        reviewedAvatar: null,
        postId: null,
        level: null,
        superiorId: null,
        text: null,
        auditStatus: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        commenterId: [{ required: true, message: "评论人ID不能为空", trigger: "blur" }],
        commenterNickname: [{ required: true, message: "评论人昵称不能为空", trigger: "blur" }],
        reviewedId: [{ required: true, message: "被评论人ID不能为空", trigger: "blur" }],
        reviewedNickname: [{ required: true, message: "被评论人昵称不能为空", trigger: "blur" }],
        postId: [{ required: true, message: "帖子ID不能为空", trigger: "blur" }],
        auditStatus: [{ required: true, message: "审核状态不能为空", trigger: "change" }],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getCommentPage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form = {
        id: undefined,
        commenterId: undefined,
        commenterNickname: undefined,
        commenterAvatar: undefined,
        reviewedId: undefined,
        reviewedNickname: undefined,
        reviewedAvatar: undefined,
        postId: undefined,
        level: undefined,
        superiorId: undefined,
        text: undefined,
        auditStatus: undefined,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNo = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加评论";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getComment(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改评论";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        // 修改的提交
        if (this.form.id != null) {
          updateComment(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createComment(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除评论编号为"' + id + '"的数据项?').then(function() {
          return deleteComment(id);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = {...this.queryParams};
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有评论数据项?').then(() => {
          this.exportLoading = true;
          return exportCommentExcel(params);
        }).then(response => {
          this.$download.excel(response, '评论.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
