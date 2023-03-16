<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="标题" prop="title">-->
<!--        <el-input v-model="queryParams.title" placeholder="请输入标题" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="宣讲会名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入宣讲会名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="宣讲地址" prop="address">
        <el-input v-model="queryParams.address" placeholder="请输入宣讲地址" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="主讲人" prop="speaker">
        <el-input v-model="queryParams.speaker" placeholder="请输入主讲人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="主题" prop="topic">
        <el-input v-model="queryParams.topic" placeholder="请输入主题" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="宣讲会主办方" prop="organizer">
        <el-input v-model="queryParams.organizer" placeholder="请输入宣讲会主办方" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
<!--      <el-form-item label="联系邮箱" prop="email">-->
<!--        <el-input v-model="queryParams.email" placeholder="请输入联系邮箱" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="开始时间" prop="startTime">
        <el-date-picker v-model="queryParams.startTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="结束时间" prop="endTime">
        <el-date-picker v-model="queryParams.endTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
<!--      <el-form-item label="关注人数" prop="concernsNumber">-->
<!--        <el-input v-model="queryParams.concernsNumber" placeholder="请输入关注人数" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="开启状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择开启状态" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.COMMON_STATUS)"
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
                   v-hasPermi="['information:careertalk:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['information:careertalk:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="宣讲会名称" align="center" prop="name" />
      <el-table-column label="宣讲地址" align="center" prop="address" />
      <el-table-column label="主讲人" align="center" prop="speaker" />
      <el-table-column label="主题" align="center" prop="topic" />
      <el-table-column label="宣讲会主办方" align="center" prop="organizer" />
<!--      <el-table-column label="联系邮箱" align="center" prop="email" />-->
<!--      <el-table-column label="内容" align="center" prop="text" />-->
      <el-table-column label="开始时间" align="center" prop="startTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.startTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束时间" align="center" prop="endTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.endTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="关注人数" align="center" prop="concernsNumber" />
      <el-table-column label="开启状态" align="center" prop="status">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.COMMON_STATUS" :value="scope.row.status" />
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
                     v-hasPermi="['information:careertalk:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['information:careertalk:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="宣讲会名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入宣讲会名称" />
        </el-form-item>
        <el-form-item label="宣讲地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入宣讲地址" />
        </el-form-item>
        <el-form-item label="主讲人" prop="speaker">
          <el-input v-model="form.speaker" placeholder="请输入主讲人" />
        </el-form-item>
        <el-form-item label="主题" prop="topic">
          <el-input v-model="form.topic" placeholder="请输入主题" />
        </el-form-item>
        <el-form-item label="宣讲会主办方" prop="organizer">
          <el-input v-model="form.organizer" placeholder="请输入宣讲会主办方" />
        </el-form-item>
        <el-form-item label="联系邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入联系邮箱" />
        </el-form-item>
        <el-form-item label="内容">
          <editor v-model="form.text" :min-height="192"/>
        </el-form-item>
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable v-model="form.startTime" type="datetime"  value-format="timestamp" placeholder="选择开始时间" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable v-model="form.endTime" type="datetime" value-format="timestamp" placeholder="选择结束时间" />
        </el-form-item>
<!--        <el-form-item label="关注人数" prop="concernsNumber">-->
<!--          <el-input v-model="form.concernsNumber" placeholder="请输入关注人数" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="开启状态" prop="status">-->
<!--          <el-select v-model="form.status" placeholder="请选择开启状态">-->
<!--            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.COMMON_STATUS)"-->
<!--                       :key="dict.value" :label="dict.label" :value="dict.value" />-->
<!--          </el-select>-->
<!--        </el-form-item>-->
        <el-form-item label="开启状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio v-for="dict in statusDictDatas" :key="parseInt(dict.value)" :label="parseInt(dict.value)">
              {{dict.label}}</el-radio>
          </el-radio-group>
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
import { createCareertalk, updateCareertalk, deleteCareertalk, getCareertalk, getCareertalkPage, exportCareertalkExcel } from "@/api/information/careertalk";
import Editor from '@/components/Editor';
import {DICT_TYPE, getDictDatas} from "@/utils/dict";

export default {
  name: "Careertalk",
  components: {
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
      // 宣讲会列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        title: null,
        name: null,
        address: null,
        speaker: null,
        topic: null,
        organizer: null,
        email: null,
        text: null,
        startTime: [],
        endTime: [],
        concernsNumber: null,
        status: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [{ required: true, message: "标题不能为空", trigger: "blur" }],
        name: [{ required: true, message: "宣讲会名称不能为空", trigger: "blur" }],
        address: [{ required: true, message: "宣讲地址不能为空", trigger: "blur" }],
        speaker: [{ required: true, message: "主讲人不能为空", trigger: "blur" }],
        topic: [{ required: true, message: "主题不能为空", trigger: "blur" }],
        text: [{ required: true, message: "内容不能为空", trigger: "blur" }],
        startTime: [{ required: true, message: "开始时间不能为空", trigger: "blur" }],
        endTime: [{ required: true, message: "结束时间不能为空", trigger: "blur" }],
      },
      // 数据字典
      statusDictDatas: getDictDatas(DICT_TYPE.COMMON_STATUS),
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
      getCareertalkPage(this.queryParams).then(response => {
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
        title: undefined,
        name: undefined,
        address: undefined,
        speaker: undefined,
        topic: undefined,
        organizer: undefined,
        email: undefined,
        text: undefined,
        startTime: undefined,
        endTime: undefined,
        concernsNumber: undefined,
        status: undefined,
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
      this.title = "添加宣讲会";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getCareertalk(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改宣讲会";
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
          updateCareertalk(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createCareertalk(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除宣讲会编号为"' + id + '"的数据项?').then(function() {
          return deleteCareertalk(id);
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
      this.$modal.confirm('是否确认导出所有宣讲会数据项?').then(() => {
          this.exportLoading = true;
          return exportCareertalkExcel(params);
        }).then(response => {
          this.$download.excel(response, '宣讲会.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
