import http from "../http-common";

class FindOddIntService {
  find(data) {
    return http.post("/findoddint",data);
  }
}

export default new FindOddIntService();