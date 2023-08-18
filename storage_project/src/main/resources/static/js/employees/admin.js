const logOutButton = document.getElementById('logout-button');

const modal = document.getElementById('modal')
const password_button = document.getElementById('password-btn')
const password_close_span = document.getElementById('modal-close')

logOutButton.addEventListener('click', function() {
    const url = `/logout`;
    window.location.href = url;
});

password_button.onclick = function () {
    modal.style.visibility = "visible"
}

password_close_span.onclick = function () {
    modal.style.visibility = "hidden"
    document.getElementById("password-input").value = ''
}