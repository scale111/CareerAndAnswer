<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生学号" prop="studentNumber">
        <el-input v-model="queryParams.studentNumber" placeholder="请输入学生学号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
<!--      <el-form-item label="手机号" prop="mobile">-->
<!--        <el-input v-model="queryParams.mobile" placeholder="请输入手机号" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="姓名" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入姓名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="身份证号" prop="idCard">
        <el-input v-model="queryParams.idCard" placeholder="请输入身份证号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.SYSTEM_USER_SEX)"
                       :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
<!--      <el-form-item label="学校" prop="school">-->
<!--        <el-input v-model="queryParams.school" placeholder="请输入学校" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
      <el-form-item label="学院" prop="college">
        <el-input v-model="queryParams.college" placeholder="请输入学院" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="专业" prop="major">
        <el-input v-model="queryParams.major" placeholder="请输入专业" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="就业状态" prop="employmentStatus">
        <el-input v-model="queryParams.employmentStatus" placeholder="请选择就业状态" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
<!--      <el-form-item label="openid" prop="openid">-->
<!--        <el-input v-model="queryParams.openid" placeholder="请输入openid" clearable @keyup.enter.native="handleQuery"/>-->
<!--      </el-form-item>-->
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
                   v-hasPermi="['member:student:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['member:student:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="学生ID" align="center" prop="id" />
      <el-table-column label="学生学号" align="center" prop="studentNumber" />
      <el-table-column label="手机号" align="center" prop="mobile" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="身份证号" align="center" prop="idCard" />
      <el-table-column label="性别" align="center" prop="gender">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.SYSTEM_USER_SEX" :value="scope.row.gender" />
        </template>
      </el-table-column>
      <el-table-column label="学校" align="center" prop="school" />
      <el-table-column label="学院" align="center" prop="college" />
      <el-table-column label="专业" align="center" prop="major" />
      <el-table-column label="就业状态" align="center" prop="employmentStatus" />
<!--      <el-table-column label="openid" align="center" prop="openid" />-->
<!--      <el-table-column label="创建时间" align="center" prop="createTime" width="180">-->
<!--        <template v-slot="scope">-->
<!--          <span>{{ parseTime(scope.row.createTime) }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['member:student:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['member:student:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生学号" prop="studentNumber">
          <el-input v-model="form.studentNumber" placeholder="请输入学生学号" />
        </el-form-item>
        <el-form-item label="手机号" prop="mobile">
          <el-input v-model="form.mobile" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="form.gender" placeholder="请选择性别">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.SYSTEM_USER_SEX)"
                       :key="dict.value" :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="学校" prop="school">
          <el-input v-model="form.school" placeholder="请输入学校" />
        </el-form-item>
        <el-form-item label="学院" prop="college">
          <el-input v-model="form.college" placeholder="请输入学院" />
        </el-form-item>
        <el-form-item label="专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入专业" />
        </el-form-item>
        <el-form-item label="就业状态" prop="employmentStatus">
          <el-input v-model="form.employmentStatus" placeholder="请选择就业状态" />
        </el-form-item>
        <el-form-item label="openid" prop="openid">
          <el-input v-model="form.openid" placeholder="请输入openid" />
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
import { createStudent, updateStudent, deleteStudent, getStudent, getStudentPage, exportStudentExcel } from "@/api/member/student";

export default {
  name: "Student",
  components: {
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
      // 学生信息列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        studentNumber: null,
        mobile: null,
        name: null,
        idCard: null,
        gender: null,
        school: null,
        college: null,
        major: null,
        employmentStatus: null,
        openid: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        studentNumber: [{ required: true, message: "学生学号不能为空", trigger: "blur" }],
        mobile: [{ required: true, message: "手机号不能为空", trigger: "blur" }],
        name: [{ required: true, message: "姓名不能为空", trigger: "blur" }],
        idCard: [{ required: true, message: "身份证号不能为空", trigger: "blur" }],
        gender: [{ required: true, message: "性别不能为空", trigger: "change" }],
        school: [{ required: true, message: "学校不能为空", trigger: "blur" }],
        college: [{ required: true, message: "学院不能为空", trigger: "blur" }],
        major: [{ required: true, message: "专业不能为空", trigger: "blur" }],
        employmentStatus: [{ required: true, message: "就业状态不能为空", trigger: "change" }],
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
      getStudentPage(this.queryParams).then(response => {
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
        studentNumber: undefined,
        mobile: undefined,
        name: undefined,
        idCard: undefined,
        gender: undefined,
        school: undefined,
        college: undefined,
        major: undefined,
        employmentStatus: undefined,
        openid: undefined,
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
      this.title = "添加学生信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getStudent(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生信息";
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
          updateStudent(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createStudent(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除学生信息编号为"' + id + '"的数据项?').then(function() {
          return deleteStudent(id);
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
      this.$modal.confirm('是否确认导出所有学生信息数据项?').then(() => {
          this.exportLoading = true;
          return exportStudentExcel(params);
        }).then(response => {
          this.$download.excel(response, '学生信息.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
