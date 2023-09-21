
document.getElementById("form").addEventListener("submit", function() {
  const name = document.getElementById("name").value;
  const description = document.getElementById("description").value;
  const price = document.getElementById("price").value;
  const amount = document.getElementById("amount").value;
  const category = document.getElementById("category").value;

  const newProduct = {
    name,
    description,
    price,
    amount,
    category
  }

  fetch("http://localhost:8080/api/produtos", {
    method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newProduct)
    }).then(res => res.json()).then(newProduct => console.log(newProduct)).catch(error => console.log(error));
})

document.getElementById("oneProduct").addEventListener("submit", function() {
  const product = document.getElementById("product").value;

    fetch(`http://localhost:8080/api/produtos/${product}`).then((data) =>{
      return data.json();
    }).then((productShow) =>{
      let data1 = "";
      productShow.map((values) =>{
          data1 += `
      <tbody>
        <tr>
          <td scope="row">${values.id}</th>
          <td>${values.name}</th>
          <td>${values.description}</th>
          <td>${values.price}</th>
          <td>${values.amount}</th>
          <td>${values.category}</th>
        </tr>
      </tbody>`
    })
    document.getElementById("productData").innerHTML = data1;
    console.log(allProducts);
  });
})


fetch("http://localhost:8080/api/produtos").then((data)=>{
  return data.json();
}).then((allProducts) =>{
    let data1 = "";
    allProducts.map((values) =>{
        data1 += `
    <tbody>
      <tr>
        <td scope="row">${values.id}</th>
        <td>${values.name}</th>
        <td>${values.description}</th>
        <td>${values.price}</th>
        <td>${values.amount}</th>
        <td>${values.category}</th>
      </tr>
    </tbody>
    `
  })
  document.getElementById("productData").innerHTML = data1;
  console.log(allProducts);
})


