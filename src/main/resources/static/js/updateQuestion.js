/**
 *
 * @author Akhil
 * @returns
 */
async function updateQuestion(e) {
  //   console.log(qid);

  localStorage.setItem("operationQuestion", "updateQuestion");

  console.log(localStorage.getItem("operationQuestion"));

  window.location.href = "/src/main/resources/static/html/newQuestion.html";
}
