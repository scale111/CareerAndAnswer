import request from '@/utils/request'

// 创建招聘会
export function createJobfair(data) {
  return request({
    url: '/information/jobfair/create',
    method: 'post',
    data: data
  })
}

// 更新招聘会
export function updateJobfair(data) {
  return request({
    url: '/information/jobfair/update',
    method: 'put',
    data: data
  })
}

// 删除招聘会
export function deleteJobfair(id) {
  return request({
    url: '/information/jobfair/delete?id=' + id,
    method: 'delete'
  })
}

// 获得招聘会
export function getJobfair(id) {
  return request({
    url: '/information/jobfair/get?id=' + id,
    method: 'get'
  })
}

// 获得招聘会分页
export function getJobfairPage(query) {
  return request({
    url: '/information/jobfair/page',
    method: 'get',
    params: query
  })
}

// 导出招聘会 Excel
export function exportJobfairExcel(query) {
  return request({
    url: '/information/jobfair/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
