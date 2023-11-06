export default {
  // 가격 쉼표
  getNumberFormatted(val){
    return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  }
}