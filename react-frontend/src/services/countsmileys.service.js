import http from "../http-common";

class CountSmileysService {
  count(data) {
    return http.post("/countsmileys",data);
  }
}

export default new CountSmileysService();