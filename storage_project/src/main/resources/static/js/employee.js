const modal = document.getElementById('modal')
const add_button = document.getElementById('add-btn')
const add_close_span = document.getElementById('modal-close')

add_button.onclick = function () {
    modal.style.visibility = "visible"
}

add_close_span.onclick = function () {
    modal.style.visibility = "hidden"
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
    document.getElementById("username-input").value = ''
    document.getElementById("password-input").value = ''
    document.getElementById('firstName-input').value = ''
    document.getElementById('lastName-input').value = ''
    document.getElementById('jobTitle-input').value = ''

}

const edit_modal = document.getElementById('edit-modal')
const edit_close_span = document.getElementById('edit-modal-close')

edit_close_span.onclick = function () {
    edit_modal.classList.remove('m-visible')
}

function openEditModal(id, username, firstName, lastName, jobTitle ) {
    edit_modal.classList.add('m-visible')
    const edit_id = document.getElementById('edit-id')
    const edit_username = document.getElementById("username-edit-input")
    const edit_firstName = document.getElementById('firstName-edit-input')
    const edit_lastName = document.getElementById('lastName-edit-input')
    const edit_jobTitle = document.getElementById('jobTitle-edit-input')

    edit_id.value = id
    edit_username.value = username
    edit_firstName.value = firstName
    edit_lastName.value = lastName
    edit_jobTitle.value = jobTitle
}