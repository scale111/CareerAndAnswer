import request from '@/utils/request'

// 创建帖子
export function createPost(data) {
  return request({
    url: '/forum/post/create',
    method: 'post',
    data: data
  })
}

// 更新帖子
export function updatePost(data) {
  return request({
    url: '/forum/post/update',
    method: 'put',
    data: data
  })
}

// 删除帖子
export function deletePost(id) {
  return request({
    url: '/forum/post/delete?id=' + id,
    method: 'delete'
  })
}

// 获得帖子
export function getPost(id) {
  return request({
    url: '/forum/post/get?id=' + id,
    method: 'get'
  })
}

// 获得帖子分页
export function getPostPage(query) {
  return request({
    url: '/forum/post/page',
    method: 'get',
    params: query
  })
}

// 导出帖子 Excel
export function exportPostExcel(query) {
  return request({
    url: '/forum/post/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
