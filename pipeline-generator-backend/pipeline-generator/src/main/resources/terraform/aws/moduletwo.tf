variable "AWS_ACCESS_KEY" {}
variable "AWS_SECRET_KEY" {}
provider "aws"{
  region = "us-east-1"
  access_key = "${var.AWS_ACCESS_KEY}"
  secret_key = "${var.AWS_SECRET_KEY}"
}

resource "aws_instance" "web"{
  ami = "ami-408c7f28"
  instance_type = "t1.micro"
  key_name =  "${aws_key_pair.digital-key.key_name}"
  tags {
    Name = "Digital_tool"
  }
  connection{
    user = "ec2-user"
    private_key = ""
  }
  provisioner "file" {
  source = "digital-key.pub"
  destination = "/etc/digital-key.pub"

}
}
resource "aws_key_pair" "digital-key"{
  key_name      =  "digital-key"
  public_key    =  "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDMF1RAdhXxxww5dpyJNJ4PjdpwDkZqhSerSORO2GNVmRfXmtFIxyEWifuYXNRo6ydT/wBNQ7cjNVodcjmz6rsuGM2nTI5fXF7S2vuRmEoOpU6kI6+i+b3BP2b9S8hK+ruWoXkN3AjBLUc/tyFRuqJyk7VMbR6VQ+aDQ0cv4ks0yhkQRz6f37Iv8g91+Auv2WuBhEJ2naG10c0GwC9DZWREUP3l+gES1XWoBPiIbo6daZWaVfo48oY04a8yLiUeiGeMRi7Ryht0FECgpuPXcAweNCOjSyRiuaeUrSvxwaFCACO615WMw3p9nmURluHoAUWaxkBdg8UC+Y73dodxfAVj migueleduardoromeroruiz@MacBook-Pro-de-Miguel.local"
}
