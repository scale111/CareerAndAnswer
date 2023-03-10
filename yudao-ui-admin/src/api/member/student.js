import request from '@/utils/request'

// 创建学生信息
export function createStudent(data) {
  return request({
    url: '/member/student/create',
    method: 'post',
    data: data
  })
}

// 更新学生信息
export function updateStudent(data) {
  return request({
    url: '/member/student/update',
    method: 'put',
    data: data
  })
}

// 删除学生信息
export function deleteStudent(id) {
  return request({
    url: '/member/student/delete?id=' + id,
    method: 'delete'
  })
}

// 获得学生信息
export function getStudent(id) {
  return request({
    url: '/member/student/get?id=' + id,
    method: 'get'
  })
}

// 获得学生信息分页
export function getStudentPage(query) {
  return request({
    url: '/member/student/page',
    method: 'get',
    params: query
  })
}

// 导出学生信息 Excel
export function exportStudentExcel(query) {
  return request({
    url: '/member/student/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
