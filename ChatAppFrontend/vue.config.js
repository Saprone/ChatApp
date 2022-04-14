module.exports = {
    devServer: {
        disableHostCheck: true,
        port: 8081,
        public: '0.0.0.0:8081',
        proxy: 'http://localhost:8082'
    },
    publicPath: "/"
}