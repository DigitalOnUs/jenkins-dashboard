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
  ami = "ami-1853ac65"
  instance_type = "t2.micro"
  key_name = "${aws_key_pair.key_pair.key_name}"

  provisioner "remote-exec" {
    inline = [
      "sudo yum -y remove java-1.7.0-openjdk",
      "sudo yum -y install java-1.8.0",
      "export JAVA_HOME=/usr/lib/jvm/jre-1.8.0",
      var.SERVICES
    ]
  }

  provisioner "local-exec" {
      command = "echo ${aws_instance.var.INSTANCE_NAME.public_ip} >> var.INSTANCE_NAME.txt"
  }

  connection {
    user = "var.INSTANCE_USERNAME"
    private_key = "${file("var.PATH_TO_PRIVATE_KEY")}"
  }
}
