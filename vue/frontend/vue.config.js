module.exports = {
  devServer: {
    proxy: {
      '/api': { //경로가 '/api'일때는 targer으로 요청하겠다
        target: 'http://localhost:8080',
        changeOrigin: true,
        pathRewrite: {
          '^/': ''
        }
      }
    }
  }
}