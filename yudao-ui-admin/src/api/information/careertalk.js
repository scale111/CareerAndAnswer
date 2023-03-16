import request from '@/utils/request'

// 创建宣讲会
export function createCareertalk(data) {
  return request({
    url: '/information/careertalk/create',
    method: 'post',
    data: data
  })
}

// 更新宣讲会
export function updateCareertalk(data) {
  return request({
    url: '/information/careertalk/update',
    method: 'put',
    data: data
  })
}

// 删除宣讲会
export function deleteCareertalk(id) {
  return request({
    url: '/information/careertalk/delete?id=' + id,
    method: 'delete'
  })
}

// 获得宣讲会
export function getCareertalk(id) {
  return request({
    url: '/information/careertalk/get?id=' + id,
    method: 'get'
  })
}

// 获得宣讲会分页
export function getCareertalkPage(query) {
  return request({
    url: '/information/careertalk/page',
    method: 'get',
    params: query
  })
}

// 导出宣讲会 Excel
export function exportCareertalkExcel(query) {
  return request({
    url: '/information/careertalk/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
