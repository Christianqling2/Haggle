import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/Haggle_auth/ua/login',
    method: 'post',
    data
  })
}

export function logout() {
  return request({
    url: '/Haggle_auth/login_out',
    method: 'post'
  })
}
