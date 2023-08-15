const edit_modal = document.getElementById('edit-modal')
const edit_close_span = document.getElementById('edit-modal-close')
const deleteButton = document.getElementById('deleteButton');

edit_close_span.onclick = function () {
    edit_modal.classList.remove('m-visible')
}

function openEditModal(contractorId, code, contractorName, contractNumber, contractorType, priceType) {
    edit_modal.classList.add('m-visible')
    const edit_contractorId = document.getElementById('edit-contractorId')
    const edit_code = document.getElementById('code-edit-input')
    const edit_contractorName = document.getElementById('contractorName-edit-input')
    const edit_contractNumber = document.getElementById('contractNumber-edit-input')

    edit_contractorId.value = contractorId
    edit_code.value = code
    edit_contractorName.value = contractorName
    edit_contractNumber.value = contractNumber
}

deleteButton.addEventListener('click', function() {
    const contractorId = this.getAttribute('data-contractor-id');
    const contractorTypeId = this.getAttribute('data-contractor-type-id');

    const url = `/contractors/delete?id=${contractorId}&contrTypeId=${contractorTypeId}`;
    window.location.href = url;
});



