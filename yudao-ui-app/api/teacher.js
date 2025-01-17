//请求工具参考https://ext.dcloud.net.cn/plugin?id=392
const { http } = uni.$u

//获取全部导师信息
export const getTeacherInfo = params => http.get('/member/mentor/getall', params)

//根据id获取导师信息
export const getTeacherDetailInfo = params => http.get('/member/mentor/get', params)

//修改用户头像
export const updateAvatar = filePath =>
  http.upload('/member/user/update-avatar', {
    name: 'avatarFile',
    fileType: 'image',
    filePath: filePath
  })
//修改用户昵称
export const updateNickname = params => http.put('/member/user/update-nickname', {}, { params })
