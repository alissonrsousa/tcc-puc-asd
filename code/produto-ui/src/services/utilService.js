
export default {

  formatarData (data = new Date(), callback) {
    let month = String(data.getMonth() + 1)
    let day = String(data.getDate())
    const year = String(data.getFullYear())

    if (month.length < 2) month = '0' + month
    if (day.length < 2) day = '0' + day

    return `${day}/${month}/${year}`
  }

}
