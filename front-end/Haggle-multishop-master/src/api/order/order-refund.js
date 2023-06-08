import request from '@/utils/request'

export function page(pageParam) {
  return request({
    url: '/Haggle_order/m/order/refund/page',
    method: 'get',
    params: pageParam
  })
}
