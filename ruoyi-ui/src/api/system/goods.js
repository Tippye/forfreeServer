import request from '@/utils/request'

// 查询商品信息列表
export function listGoods(query) {
  return request({
    url: '/system/goods/list',
    method: 'get',
    params: query
  })
}

// 查询商品信息详细
export function getGoods(goodsId) {
  return request({
    url: '/system/goods/' + goodsId,
    method: 'get'
  })
}

// 新增商品信息
export function addGoods(data) {
  return request({
    url: '/system/goods',
    method: 'post',
    data: data
  })
}

// 修改商品信息
export function updateGoods(data) {
  return request({
    url: '/system/goods',
    method: 'put',
    data: data
  })
}

// 删除商品信息
export function delGoods(goodsId) {
  return request({
    url: '/system/goods/' + goodsId,
    method: 'delete'
  })
}

// 导出商品信息
export function exportGoods(query) {
  return request({
    url: '/system/goods/export',
    method: 'get',
    params: query
  })
}

// 查询商品图片列表
export function listGallery(query) {
  return request({
    url: '/system/gallery/list',
    method: 'get',
    params: query
  })
}

// 查询商品图片详细
export function getGallery(goodsId) {
  return request({
    url: '/system/gallery/' + goodsId,
    method: 'get'
  })
}

// 新增商品图片
export function addGallery(data) {
  return request({
    url: '/system/gallery',
    method: 'post',
    data: data
  })
}

// 修改商品图片
export function updateGallery(data) {
  return request({
    url: '/system/gallery',
    method: 'put',
    data: data
  })
}

// 删除商品图片
export function delGallery(goodsId) {
  return request({
    url: '/system/gallery/' + goodsId,
    method: 'delete'
  })
}

// 导出商品图片
export function exportGallery(query) {
  return request({
    url: '/system/gallery/export',
    method: 'get',
    params: query
  })
}

// 查询商品标签对应关系列表
export function listGoodsTag(query) {
  return request({
    url: '/system/goodsTag/list',
    method: 'get',
    params: query
  })
}

// 查询商品标签对应关系详细
export function getGoodsTag(goodsId) {
  return request({
    url: '/system/goodsTag/' + goodsId,
    method: 'get'
  })
}

// 新增商品标签对应关系
export function addGoodsTag(data) {
  return request({
    url: '/system/goodsTag',
    method: 'post',
    data: data
  })
}

// 修改商品标签对应关系
export function updateGoodsTag(data) {
  return request({
    url: '/system/goodsTag',
    method: 'put',
    data: data
  })
}

// 删除商品标签对应关系
export function delGoodsTag(goodsId) {
  return request({
    url: '/system/goodsTag/' + goodsId,
    method: 'delete'
  })
}

// 导出商品标签对应关系
export function exportGoodsTag(query) {
  return request({
    url: '/system/goodsTag/export',
    method: 'get',
    params: query
  })
}
