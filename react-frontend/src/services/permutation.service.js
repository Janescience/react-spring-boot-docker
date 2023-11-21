import http from "../http-common";

class PermutationService {
  shuffings(text) {
    return http.get(`/permutation/${text}`);
  }
}

export default new PermutationService();