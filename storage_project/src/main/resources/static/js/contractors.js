// const modal = document.getElementById('modal')
// const add_button = document.getElementById('add-btn')
// const add_close_span = document.getElementById('modal-close')

// add_button.onclick = function () {
//     modal.style.visibility = "visible"
// }

// add_close_span.onclick = function () {
//     modal.style.visibility = "hidden"
    // const error_username = document.getElementById('error-username')
    // error_username.classList.remove('s-visible')
    // const error_firstname = document.getElementById('error-firstname')
    // error_firstname.classList.remove('s-visible')
    // const error_lastname = document.getElementById('error-lastname')
    //
    // error_lastname.classList.remove('s-visible')
    // const error_email = document.getElementById('error-email')
    // error_email.classList.remove('s-visible')
    // const error_address = document.getElementById('error-address')
    // error_address.classList.remove('s-visible')
    // const error_phone = document.getElementById('error-phone')
    // error_phone.classList.remove('s-visible')
    // // and date
    // document.getElementById('contractorName-input').value = ''
    // document.getElementById('code-input').value = ''
    // document.getElementById('contractNumber-input').value = ''

// }

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