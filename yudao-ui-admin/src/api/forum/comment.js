import request from '@/utils/request'

// 创建评论
export function createComment(data) {
  return request({
    url: '/forum/comment/create',
    method: 'post',
    data: data
  })
}

// 更新评论
export function updateComment(data) {
  return request({
    url: '/forum/comment/update',
    method: 'put',
    data: data
  })
}

// 删除评论
export function deleteComment(id) {
  return request({
    url: '/forum/comment/delete?id=' + id,
    method: 'delete'
  })
}

// 获得评论
export function getComment(id) {
  return request({
    url: '/forum/comment/get?id=' + id,
    method: 'get'
  })
}

// 获得评论分页
export function getCommentPage(query) {
  return request({
    url: '/forum/comment/page',
    method: 'get',
    params: query
  })
}

// 导出评论 Excel
export function exportCommentExcel(query) {
  return request({
    url: '/forum/comment/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
