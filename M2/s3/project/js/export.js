export default class Product {
    constructor(_name, _description, _brand, _imageUrl, _price) {
        this.name = _name;
        this.description = _description;
        this.brand = _brand;
        this.imageUrl = _imageUrl;
        this.price = _price;
    }
}

export function getId() {   
    const url = new URLSearchParams(location.search);
    const id = url.get("id");
    return id;
}