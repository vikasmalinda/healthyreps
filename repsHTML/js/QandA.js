/**
 *
 * @author Akhil
 * @returns
 */

console.log("QandA.js connected!!");

let questionContainer = document.querySelector(".post-content");
let answersContainer = document.querySelector(".home-article");

const qid = localStorage.getItem("questionId");

async function loadQuestionAndData() {
  console.log(qid);
  let question = await fetch("http://localhost:8080/question/" + qid);
  question = await question.json();
  let answers = await fetch(
    `http://localhost:8080/question/${qid}/answer/order/desc`
  );
  let answersArr = await answers.json();

  console.log(question);
  console.log(answersArr);
  renderData(question, answersArr);
}

async function renderData(q, answers) {
  // Rendering Question
  let question = `
   <h1 class="font1">Question ${q.questionId}</h1>
   <p class="font1">
    ${q.title}
   </p>
   <div class="post-meta">
     <div class="author-info">
       <div><b> ${getUser(q.userId)}</b></div>
       <div>${q.modifiedAt}</div>
     </div>
     <div class="social">
       <svg width="29" height="29" class="jw">
         <path
           d="M22.05 7.54a4.47 4.47 0 0 0-3.3-1.46 4.53 4.53 0 0 0-4.53 4.53c0 .35.04.7.08 1.05A12.9 12.9 0 0 1 5 6.89a5.1 5.1 0 0 0-.65 2.26c.03 1.6.83 2.99 2.02 3.79a4.3 4.3 0 0 1-2.02-.57v.08a4.55 4.55 0 0 0 3.63 4.44c-.4.08-.8.13-1.21.16l-.81-.08a4.54 4.54 0 0 0 4.2 3.15 9.56 9.56 0 0 1-5.66 1.94l-1.05-.08c2 1.27 4.38 2.02 6.94 2.02 8.3 0 12.86-6.9 12.84-12.85.02-.24 0-.43 0-.65a8.68 8.68 0 0 0 2.26-2.34c-.82.38-1.7.62-2.6.72a4.37 4.37 0 0 0 1.95-2.51c-.84.53-1.81.9-2.83 1.13z"
         ></path>
       </svg>
       <svg width="29" height="29" class="jw">
         <path
           d="M23.2 5H5.8a.8.8 0 0 0-.8.8V23.2c0 .44.35.8.8.8h9.3v-7.13h-2.38V13.9h2.38v-2.38c0-2.45 1.55-3.66 3.74-3.66 1.05 0 1.95.08 2.2.11v2.57h-1.5c-1.2 0-1.48.57-1.48 1.4v1.96h2.97l-.6 2.97h-2.37l.05 7.12h5.1a.8.8 0 0 0 .79-.8V5.8a.8.8 0 0 0-.8-.79"
         ></path>
       </svg>
     </div>
   </div>`;
  questionContainer.innerHTML += question;
  //End of question Rendering

  // Start of Answers

  let renderedAnswers = await getAnswers(answers);

  // console.log(renderedAnswers);
  answersContainer.innerHTML += renderedAnswers;
}

async function getAnswers(answers) {
  let renderedAnswers = "";

  // forEach doesn't work with async and await  inside loop :(
  for (let ans of answers) {
    let arr = await renderComments(ans.answerID);
    // console.log(arr);
    //  let arr= await test1();
    renderedAnswers += ` <div class="home-article-content font1">
       <h3>${ans.description}</h3>
       <span>${getUser(ans.userId)} |</span>
       <span>${ans.modifiedAt}</span>
       <div class="comment">
        
          ${arr}
       
         
       </div>
     </div> `;
  }

  return renderedAnswers;
}

async function renderComments(aid) {
  let arr = await fetch(`http://localhost:8080/answer/${aid}/comment`);
  let comments = await arr.json();

  console.log(comments);

  let rendComments = "";

  comments.forEach((el) => {
    rendComments += `<div class="comment-box">
         <input type="text " placeholder="Add a comment... " />
         <button class="btn">Add Comment</button>
       </div>
       <div class="comment-content">
         <hr />
         <span> ${el.commentID} |</span>
         <span>${el.modifiedAt}</span>
         <p>
          ${el.description}
         </p>
         <div class="vote">
           <span class="count">${el.reliability}</span>
           <button>up</button>
           <button>down</button>
         </div>
        
         
       </div>`;
  });
  // console.log(rendComments);
  return rendComments;
}

//testing function
async function test1() {
  return "hahaha";
}

// function to get user by User ID;
function getUser(id) {
  return "Akhil";
}

document.addEventListener("DOMContentLoaded", loadQuestionAndData);
