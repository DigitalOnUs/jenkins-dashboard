resource "aws_key_pair" "key_pair" {
  key_name = "var.KEY_PAIR_NAME"
  public_key = "${file("var.PATH_TO_PUBLIC_KEY")}"
}

provider "aws" {
        region = "us-east-1"
        access_key = "var.ACCESS_KEY"
        secret_key = "var.SECRET_KEY"
}

resource "aws_instance" "var.INSTANCE_NAME" {
  ami = "ami-408c7f28"
  instance_type = "t1.micro"
  key_name = "${aws_key_pair.key_pair.key_name}"

  provisioner "remote-exec" {
    inline = [
      var.SERVICES
    ]
  }

  connection {
    user = "var.INSTANCE_USERNAME"
    private_key = "${file("var.PATH_TO_PRIVATE_KEY")}"
  }
}
