<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="发帖人ID" prop="userId">
        <el-input v-model="queryParams.userId" placeholder="请输入发帖人ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="发帖人昵称" prop="userNickname">
        <el-input v-model="queryParams.userNickname" placeholder="请输入发帖人昵称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
<!--      <el-form-item label="标题" prop="title">-->
<!--        <el-input v-model="queryParams.title" placeholder="请输入标题" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="评论数" prop="commentNumber">-->
<!--        <el-input v-model="queryParams.commentNumber" placeholder="请输入评论数" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="点赞数" prop="likeNumber">-->
<!--        <el-input v-model="queryParams.likeNumber" placeholder="请输入点赞数" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="不喜欢数" prop="unlikeNumber">-->
<!--        <el-input v-model="queryParams.unlikeNumber" placeholder="请输入不喜欢数" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="置顶状态" prop="sticky">
        <el-select v-model="queryParams.sticky" placeholder="请选择置顶状态" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.STICKY_STATUS)"
                       :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
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
                   v-hasPermi="['forum:post:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['forum:post:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="帖子ID" align="center" prop="id" />
      <el-table-column label="发帖人ID" align="center" prop="userId" />
      <el-table-column label="发帖人昵称" align="center" prop="userNickname" />
<!--      <el-table-column label="发帖人头像" align="center" prop="avatar" />-->
      <el-table-column label="发帖人头像" align="center" prop="avatar" >
        <template slot-scope="scope">
          <img :src="scope.row.avatar" style="width:100px;height:100px;"/>
        </template>
      </el-table-column>
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="内容" align="center" prop="text" />
      <el-table-column label="评论数" align="center" prop="commentNumber" />
      <el-table-column label="点赞数" align="center" prop="likeNumber" />
      <el-table-column label="不喜欢数" align="center" prop="unlikeNumber" />
      <el-table-column label="置顶状态" align="center" prop="sticky">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.STICKY_STATUS" :value="scope.row.sticky" />
        </template>
      </el-table-column>
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
                     v-hasPermi="['forum:post:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['forum:post:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="发帖人ID" prop="userId">-->
<!--          <el-input v-model="form.userId" placeholder="请输入发帖人ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="发帖人昵称" prop="userNickname">-->
<!--          <el-input v-model="form.userNickname" placeholder="请输入发帖人昵称" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="发帖人头像">-->
<!--          <imageUpload v-model="form.avatar"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="标题" prop="title">-->
<!--          <el-input v-model="form.title" placeholder="请输入标题" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="内容">-->
<!--          <editor v-model="form.text" :min-height="192"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="评论数" prop="commentNumber">-->
<!--          <el-input v-model="form.commentNumber" placeholder="请输入评论数" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="点赞数" prop="likeNumber">-->
<!--          <el-input v-model="form.likeNumber" placeholder="请输入点赞数" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="不喜欢数" prop="unlikeNumber">-->
<!--          <el-input v-model="form.unlikeNumber" placeholder="请输入不喜欢数" />-->
<!--        </el-form-item>-->
        <el-form-item label="置顶状态" prop="sticky">
          <el-select v-model="form.sticky" placeholder="请选择置顶状态">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.STICKY_STATUS)"
                       :key="parseInt(dict.value)" :label="dict.label" :value="parseInt(dict.value)" />
          </el-select>
        </el-form-item>
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
import { createPost, updatePost, deletePost, getPost, getPostPage, exportPostExcel } from "@/api/forum/post";
import Editor from '@/components/Editor';
import ImageUpload from '@/components/ImageUpload';

export default {
  name: "Post",
  components: {
    ImageUpload,
    Editor,
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
      // 帖子列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        userId: null,
        userNickname: null,
        avatar: null,
        title: null,
        text: null,
        commentNumber: null,
        likeNumber: null,
        unlikeNumber: null,
        sticky: null,
        auditStatus: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [{ required: true, message: "发帖人ID不能为空", trigger: "blur" }],
        userNickname: [{ required: true, message: "发帖人昵称不能为空", trigger: "blur" }],
        text: [{ required: true, message: "内容不能为空", trigger: "blur" }],
        sticky: [{ required: true, message: "置顶状态不能为空", trigger: "change" }],
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
      getPostPage(this.queryParams).then(response => {
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
        userId: undefined,
        userNickname: undefined,
        avatar: undefined,
        title: undefined,
        text: undefined,
        commentNumber: undefined,
        likeNumber: undefined,
        unlikeNumber: undefined,
        sticky: undefined,
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
      this.title = "添加帖子";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getPost(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改帖子";
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
          updatePost(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createPost(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除帖子编号为"' + id + '"的数据项?').then(function() {
          return deletePost(id);
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
      this.$modal.confirm('是否确认导出所有帖子数据项?').then(() => {
          this.exportLoading = true;
          return exportPostExcel(params);
        }).then(response => {
          this.$download.excel(response, '帖子.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
