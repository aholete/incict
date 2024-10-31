let timerInterval;
let timeRemaining = 0;
let isRunning = false;

function chooseNext() {
    const numParticipants = document.getElementById('numParticipants').value;
    if (numParticipants && numParticipants > 0) {
        const chosenNum = Math.floor(Math.random() * numParticipants) + 1;
        document.getElementById('chosenNum').textContent = chosenNum;
    } else {
        alert("Please enter a valid number of participants.");
    }
}

function toggleTimer() {
    if (isRunning) {
        stopTimer();
    } else {
        startTimer();
    }
}

function startTimer() {
    document.getElementById('timerButton').textContent = "Stop";
    timerInterval = setInterval(() => {
        timeRemaining++;
        displayTime();
    }, 1000);
    isRunning = true;
}

function stopTimer() {
    clearInterval(timerInterval);
    document.getElementById('timerButton').textContent = "Start";
    isRunning = false;
}

function resetTimer() {
    stopTimer();
    timeRemaining = 0;
    displayTime();
}

function displayTime() {
    const minutes = String(Math.floor(timeRemaining / 60)).padStart(2, '0');
    const seconds = String(timeRemaining % 60).padStart(2, '0');
    document.getElementById('timeDisplay').textContent = `${minutes}:${seconds}`;
}

function loadImage(event) {
    const selectedImage = document.getElementById('selectedImage');
    selectedImage.src = URL.createObjectURL(event.target.files[0]);
    selectedImage.onload = () => {
        URL.revokeObjectURL(selectedImage.src);
    };
}
