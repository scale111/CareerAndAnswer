//请求工具参考https://ext.dcloud.net.cn/plugin?id=392
const { http } = uni.$u

//获取招聘信息
export const getrecruitment = data => http.get('/information/recruitment/getall', data)

export const wxlogin = data => http.post('/member/auth/social-login', data)

//根据id获取招聘信息

export const getrecruitmentByid = data => http.get('/information/recruitment/get', data)