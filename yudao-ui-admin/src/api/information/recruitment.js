import request from '@/utils/request'

// 创建招聘信息
export function createRecruitment(data) {
  return request({
    url: '/information/recruitment/create',
    method: 'post',
    data: data
  })
}

// 更新招聘信息
export function updateRecruitment(data) {
  return request({
    url: '/information/recruitment/update',
    method: 'put',
    data: data
  })
}

// 删除招聘信息
export function deleteRecruitment(id) {
  return request({
    url: '/information/recruitment/delete?id=' + id,
    method: 'delete'
  })
}

// 获得招聘信息
export function getRecruitment(id) {
  return request({
    url: '/information/recruitment/get?id=' + id,
    method: 'get'
  })
}

// 获得招聘信息分页
export function getRecruitmentPage(query) {
  return request({
    url: '/information/recruitment/page',
    method: 'get',
    params: query
  })
}

// 导出招聘信息 Excel
export function exportRecruitmentExcel(query) {
  return request({
    url: '/information/recruitment/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
