function addRow(products, measureUnits){

    const div = document.getElementById("table")
    const row = document.createElement("div")
     row.classList.add("dinamic-line")
    const div2 = document.createElement("div")
    row.appendChild(div2);

    const select1 = document.createElement("select")
    for(let i = 0; i<products.size; i++){
        let productOption = document.createElement(`option`)
        productOption.value = products[i].productId
        productOption.text = products[i].name

        select1.appendChild(productOption)
    }
    select1.addEventListener('change', function (){
        const selectedProductId = this.value;
    })

    const select2 = document.createElement("select")
    for(let i = 0; i<measureUnits.size; i++){
        let measureUnitOption = document.createElement("option")
        measureUnitOption.value = measureUnits[i].measureUnitId
        measureUnitOption.text = measureUnits[i].measureName
        select2.appendChild(measureUnitOption)
    }
    select2.addEventListener('change', function (){
        const selectedMeasureUnitId = this.value;
    })
    row.appendChild(select1);
    row.appendChild(select2)

    const input4 = document.createElement("input")
    input4.type = "text"
    row.appendChild(input4)

    div.appendChild(row)
    document.body.appendChild(div)
}