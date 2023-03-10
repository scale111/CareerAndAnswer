import request from '@/utils/request'

// 创建导师信息
export function createMentor(data) {
  return request({
    url: '/member/mentor/create',
    method: 'post',
    data: data
  })
}

// 更新导师信息
export function updateMentor(data) {
  return request({
    url: '/member/mentor/update',
    method: 'put',
    data: data
  })
}

// 删除导师信息
export function deleteMentor(id) {
  return request({
    url: '/member/mentor/delete?id=' + id,
    method: 'delete'
  })
}

// 获得导师信息
export function getMentor(id) {
  return request({
    url: '/member/mentor/get?id=' + id,
    method: 'get'
  })
}

// 获得导师信息分页
export function getMentorPage(query) {
  return request({
    url: '/member/mentor/page',
    method: 'get',
    params: query
  })
}

// 导出导师信息 Excel
export function exportMentorExcel(query) {
  return request({
    url: '/member/mentor/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
