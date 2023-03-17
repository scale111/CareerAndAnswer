<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="标题" prop="title">-->
<!--        <el-input v-model="queryParams.title" placeholder="请输入标题" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="职位" prop="position">-->
<!--        <el-input v-model="queryParams.position" placeholder="请输入职位" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="招聘类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择招聘类型" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.INFORMATION_RECRUITMENT_TYPE)"
                       :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
<!--      <el-form-item label="公司名" prop="company">-->
<!--        <el-input v-model="queryParams.company" placeholder="请输入公司名" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="工作地点" prop="address">
        <el-input v-model="queryParams.address" placeholder="请输入工作地点" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
<!--      <el-form-item label="招聘人数" prop="recruitsNumber">-->
<!--        <el-input v-model="queryParams.recruitsNumber" placeholder="请输入招聘人数" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="薪资" prop="salary">-->
<!--        <el-input v-model="queryParams.salary" placeholder="请输入薪资" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="学历要求" prop="education">
        <el-select v-model="queryParams.education" placeholder="请选择学历要求" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.INFORMATION_RECRUITMENT_EDUCATION)"
                       :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
<!--      <el-form-item label="发布时间" prop="releaseTime">-->
<!--        <el-date-picker v-model="queryParams.releaseTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"-->
<!--                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="过期时间" prop="expirationTime">-->
<!--        <el-date-picker v-model="queryParams.expirationTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"-->
<!--                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />-->
<!--      </el-form-item>-->
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
                   v-hasPermi="['information:recruitment:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['information:recruitment:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="ID" align="center" prop="id" />
<!--      <el-table-column label="标题" align="center" prop="title" />-->
      <el-table-column label="职位" align="center" prop="position" />
      <el-table-column label="招聘类型" align="center" prop="type">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.INFORMATION_RECRUITMENT_TYPE" :value="scope.row.type" />
        </template>
      </el-table-column>
      <el-table-column label="公司名" align="center" prop="company" />
<!--      <el-table-column label="工作地点" align="center" prop="address" />-->
<!--      <el-table-column label="招聘人数" align="center" prop="recruitsNumber" />-->
      <el-table-column label="薪资" align="center" prop="salary" />
      <el-table-column label="学历要求" align="center" prop="education">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.INFORMATION_RECRUITMENT_EDUCATION" :value="scope.row.education" />
        </template>
      </el-table-column>
<!--      <el-table-column label="内容" align="center" prop="text" />-->
<!--      <el-table-column label="发布时间" align="center" prop="releaseTime" width="180">-->
<!--        <template v-slot="scope">-->
<!--          <span>{{ parseTime(scope.row.releaseTime) }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="过期时间" align="center" prop="expirationTime" width="180">-->
<!--        <template v-slot="scope">-->
<!--          <span>{{ parseTime(scope.row.expirationTime) }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
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
                     v-hasPermi="['information:recruitment:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['information:recruitment:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="800px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="职位" prop="position">
          <el-input v-model="form.position" placeholder="请输入职位" />
        </el-form-item>
        <el-form-item label="招聘类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择招聘类型">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.INFORMATION_RECRUITMENT_TYPE)"
                       :key="parseInt(dict.value)" :label="dict.label" :value="parseInt(dict.value)" />
          </el-select>
        </el-form-item>
        <el-form-item label="公司名" prop="company">
          <el-input v-model="form.company" placeholder="请输入公司名" />
        </el-form-item>
        <el-form-item label="工作地点" prop="address">
          <el-input v-model="form.address" placeholder="请输入工作地点" />
        </el-form-item>
        <el-form-item label="招聘人数" prop="recruitsNumber">
          <el-input v-model="form.recruitsNumber" placeholder="请输入招聘人数" />
        </el-form-item>
        <el-form-item label="薪资" prop="salary">
          <el-input v-model="form.salary" placeholder="请输入薪资" />
        </el-form-item>
        <el-form-item label="学历要求" prop="education">
          <el-select v-model="form.education" placeholder="请选择学历要求">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.INFORMATION_RECRUITMENT_EDUCATION)"
                       :key="parseInt(dict.value)" :label="dict.label" :value="parseInt(dict.value)" />
          </el-select>
        </el-form-item>
        <el-form-item label="内容">
          <editor v-model="form.text" :min-height="192"/>
        </el-form-item>
        <el-form-item label="发布时间" prop="releaseTime">
          <el-date-picker clearable v-model="form.releaseTime" type="date" value-format="timestamp" placeholder="选择发布时间" />
        </el-form-item>
        <el-form-item label="过期时间" prop="expirationTime">
          <el-date-picker clearable v-model="form.expirationTime" type="date" value-format="timestamp" placeholder="选择过期时间" />
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
import { createRecruitment, updateRecruitment, deleteRecruitment, getRecruitment, getRecruitmentPage, exportRecruitmentExcel } from "@/api/information/recruitment";
import Editor from '@/components/Editor';
import {DICT_TYPE, getDictDatas} from "@/utils/dict";

export default {
  name: "Recruitment",
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
      // 招聘信息列表
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
        position: null,
        type: null,
        company: null,
        address: null,
        recruitsNumber: null,
        salary: null,
        education: null,
        text: null,
        releaseTime: [],
        expirationTime: [],
        concernsNumber: null,
        status: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [{ required: true, message: "标题不能为空", trigger: "blur" }],
        position: [{ required: true, message: "职位不能为空", trigger: "blur" }],
        type: [{ required: true, message: "招聘类型不能为空", trigger: "change" }],
        company: [{ required: true, message: "公司名不能为空", trigger: "blur" }],
        address: [{ required: true, message: "工作地点不能为空", trigger: "blur" }],
        salary: [{ required: true, message: "薪资不能为空", trigger: "blur" }],
        education: [{ required: true, message: "学历要求不能为空", trigger: "change" }],
        text: [{ required: true, message: "内容不能为空", trigger: "blur" }],
        releaseTime: [{ required: true, message: "发布时间不能为空", trigger: "blur" }],
        expirationTime: [{ required: true, message: "过期时间不能为空", trigger: "blur" }],
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
      getRecruitmentPage(this.queryParams).then(response => {
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
        position: undefined,
        type: undefined,
        company: undefined,
        address: undefined,
        recruitsNumber: undefined,
        salary: undefined,
        education: undefined,
        text: undefined,
        releaseTime: undefined,
        expirationTime: undefined,
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
      this.title = "添加招聘信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getRecruitment(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改招聘信息";
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
          updateRecruitment(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createRecruitment(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除招聘信息编号为"' + id + '"的数据项?').then(function() {
          return deleteRecruitment(id);
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
      this.$modal.confirm('是否确认导出所有招聘信息数据项?').then(() => {
          this.exportLoading = true;
          return exportRecruitmentExcel(params);
        }).then(response => {
          this.$download.excel(response, '招聘信息.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
