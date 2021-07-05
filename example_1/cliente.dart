import 'endereco.dart'; 

class Cliente {
  String? _nome;
  String? _RG;
  String? _CPF;
  String? _email;
  String? _telefoneParaContato;
  Endereco? _endereco;

  Cliente(
    this._nome,
    this._RG,
    this._CPF,
    this._email,
    this._telefoneParaContato,
    this._endereco
  );

  // String? get nome => this._nome;
  // String? get rg => this._RG;
  // String? get cpf => this._CPF;
  // String? get email => this._email;
  // String? get telefone => this._telefoneParaContato;
  // Endereco? get endereco => this._endereco;

  // set nome(String? nome) {
  //   this._nome = nome;
  // }

  // set rg(String? rg) {
  //   this._RG = rg;
  // }

  // set cpf(String? cpf) {
  //   this._CPF = cpf;
  // }

  // set email(String? email) {
  //   this._email = email;
  // }
}
