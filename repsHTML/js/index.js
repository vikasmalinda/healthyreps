/**
 *
 * @author Akhil
 * @returns
 */

console.log("index.js connected!!");

let container = document.querySelector(".home-articles");
let votes = document.querySelector(".votes");
let date = document.querySelector(".date");
let form = document.querySelector("#searchForm");
// console.log(form.elements.query.value);

// console.log(votes,date);

// console.log(container);

async function getAllQuestion() {
  let questions = await fetch("http://localhost:8080/allquestions");
  let arr = await questions.json();
  console.log(arr);
  renderQuestions(arr);
}

function renderQuestions(questions) {
  questions.forEach((q) => {
    let question = `<div class="home-article">
        <div class="home-article-img">
          <img src="../img/11.svg" alt="" />
        </div>

        <div class="home-article-content font1">
          <a href="/" id=${q.questionId}>
          <h3>${q.title}</h3>
          </a>

          <span>Votes ${q.votes}</span><br>
         <span>Date ${q.modifiedAt} </span>
        </div>
      </div>`;
    container.innerHTML += question;
  });
  container.addEventListener("click", goToAnswers);
}

function goToAnswers(e) {
  e.preventDefault();
  console.log(e.target.parentElement.id);
  const id = e.target.parentElement.id;
  localStorage.setItem("questionId", id);
  window.location.href = "/repsHTML/html/QandA.html";
}

// async function getQuestionsByVotes(){
//     let questions = await fetch("http://localhost:8080/allquestions");
//     let arr = await questions.json();
//     console.log(arr);
//     renderQuestions(arr);

// }

// votes.addEventListener('click',getQuestionsByVotes);

document.addEventListener("DOMContentLoaded", getAllQuestion);
