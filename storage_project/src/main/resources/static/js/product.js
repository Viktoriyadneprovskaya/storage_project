const modal = document.getElementById('modal')
const add_button = document.getElementById('add-btn')
const add_close_span = document.getElementById('modal-close')

add_button.onclick = function () {
    modal.style.visibility = "visible"
}

add_close_span.onclick = function () {
    modal.style.visibility = "hidden"

    document.getElementById('product-input').value = ''
    document.getElementById('measureUnit-input').value = ''
    document.getElementById('shelfLife-input').value = ''
    document.getElementById('basicPrice-input').value = ''
}

const edit_modal = document.getElementById('edit-modal')
const edit_close_span = document.getElementById('edit-modal-close')

edit_close_span.onclick = function () {
    edit_modal.classList.remove('m-visible')
}

function openEditModal(productId,name,measureUnit, shelfLife, basicPrice) {
    edit_modal.classList.add('m-visible')
    const edit_productId = document.getElementById('edit-productId')
    const edit_name = document.getElementById('name-edit-input')
    const edit_measureUnit = document.getElementById('measureUnit-edit-input')
    const edit_shelfLife = document.getElementById('shelfLife-edit-input')
    const edit_basicPrice = document.getElementById('basicPrice-edit-input')

    edit_productId.value = productId
    edit_name.value = name
    edit_measureUnit.value = measureUnit.option
    edit_shelfLife.value = shelfLife
    edit_basicPrice.value = basicPrice
}