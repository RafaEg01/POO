class Livro:
    def __init__(self):
        self.nome = ''
        self.autor = ''
        self.numLivro = 0
    
    def __str__(l):
        return 'Nome: {} − Autor  {} - NumLivro  {}'.format(l.nome,l.autor,l.numLivro)

class Cliente:
    def __init__(self):
        self.nome = ''
        self.endereco = ''
        self.cpf = ''
        self.telefone = ''
        self.idade = 0
    
    def __str__(c):
        return 'Nome: {} − Endereco  {} - Cpf  {} - Telefone {} Idade: {}'.format(c.nome,c.endereco,c.cpf,c.telefone,c.idade)
    


c = Cliente()
c.nome = 'Pedro'
c.endereco = 'Rua Morreira'
c.cpf = '042029931-32'
c.telefone = '(47) 3822-2312'
c.idade = 20

l = Livro()
l.nome = 'Percy Jackson'
l.nome = 'Hp lovecraft'
l.numLivro = 20

print(l)
print(c)
        