function fnGetUser() {
  let userId = document.querySelector("#user-id").value;
  console.log(userId);

  fetch("http://healthyreps.herokuapp.com/workout/" + userId)
    .then((resp) => resp.json())
    .then((resp) => {
      document.getElementById("sets").innerHTML = resp.sets;
      document.getElementById("repsSet").innerHTML = resp.reps_per_set;
    });
}
