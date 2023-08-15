const addButton = document.getElementById('add-btn');

addButton.addEventListener('click', function() {
    const url = `/contractors/new_contractor`;
    window.location.href = url;
});

