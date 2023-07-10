const edit_modal = document.getElementById('edit-modal')
const edit_close_span = document.getElementById('edit-modal-close')

edit_close_span.onclick = function () {
    edit_modal.classList.remove('m-visible')
}

function openEditModal(contractorId, code, contractorName, contractNumber, contractorType, priceType) {
    edit_modal.classList.add('m-visible')
    const edit_contractorId = document.getElementById('edit-contractorId')
    const edit_code = document.getElementById('code-edit-input')
    const edit_contractorName = document.getElementById('contractorName-edit-input')
    const edit_contractNumber = document.getElementById('contractNumber-edit-input')
    const edit_contractorType = document.getElementById('contractorType-edit-input')
    const edit_priceType = document.getElementById("priceType-edit-input")

    edit_contractorId.value = contractorId
    edit_code.value = code
    edit_contractorName.value = contractorName
    edit_contractNumber.value = contractNumber
    edit_contractorType.value = contractorType
    edit_priceType.value = priceType
}