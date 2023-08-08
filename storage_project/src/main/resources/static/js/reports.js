function startDateValidation() {
    const error = document.getElementById('error_start_date')
    const input_value = document.getElementById('start_date_input').value

    if (input_value !== "") {
        const today = new Date();
        const date = new Date(input_value);
        const error_year = new Date(1950, 1, 1);

        if (error_year < date <= today) {
            error.classList.remove('s-visible')
            document.getElementById('start_date_input').style.border = "2px solid green"
            document.getElementById('start_date_input').style.boxShadow = "inset green 0 0 5px 0"
        } else {
            error.classList.add('s-visible')
            document.getElementById('start_date_input').style.border = "2px solid red"
            document.getElementById('start_date_input').style.boxShadow = "inset red 0 0 5px 0"
        }
    } else {
        error.classList.add('s-visible')
        document.getElementById('start_date_input').style.border = "2px solid red"
        document.getElementById('start_date_input').style.boxShadow = "inset red 0 0 5px 0"
    }
}

function endDateValidation() {
    const error = document.getElementById('error_end_date')
    const input_value = document.getElementById('end_date_input').value

    if (input_value !== "") {
        const today = new Date();
        const date = new Date(input_value);
        const error_year = new Date(1950, 1, 1);

        if (error_year < date <= today) {
            error.classList.remove('s-visible')
            document.getElementById('end_date_input').style.border = "2px solid green"
            document.getElementById('end_date_input').style.boxShadow = "inset green 0 0 5px 0"
        } else {
            error.classList.add('s-visible')
            document.getElementById('end_date_input').style.border = "2px solid red"
            document.getElementById('end_date_input').style.boxShadow = "inset red 0 0 5px 0"
        }
    } else {
        error.classList.add('s-visible')
        document.getElementById('end_date_input').style.border = "2px solid red"
        document.getElementById('end_date_input').style.boxShadow = "inset red 0 0 5px 0"
    }
}


