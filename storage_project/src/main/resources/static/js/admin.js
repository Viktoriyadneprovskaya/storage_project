const logOutButton = document.getElementById('logout-button');

logOutButton.addEventListener('click', function() {
    const url = `/logout`;
    window.location.href = url;
});