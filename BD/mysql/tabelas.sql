-- MySQL Script generated by MySQL Workbench
-- Wed Aug  1 22:40:13 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema seguranca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `seguranca` DEFAULT CHARACTER SET utf8 ;
GRANT ALL PRIVILEGES ON seguranca.* TO 'admin'@'%';
USE `seguranca` ;

-- -----------------------------------------------------
-- Table `seguranca`.`status_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguranca`.`status_usuario` ;

CREATE TABLE IF NOT EXISTS `seguranca`.`status_usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `seguranca`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguranca`.`usuario` ;

CREATE TABLE IF NOT EXISTS `seguranca`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(60) NOT NULL,
  `status_usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`, `status_usuario_id`),
  CONSTRAINT `fk_usuario_status_usuario1`
    FOREIGN KEY (`status_usuario_id`)
    REFERENCES `seguranca`.`status_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_status_usuario1_idx` ON `seguranca`.`usuario` (`status_usuario_id` ASC);

CREATE INDEX `ix_login` ON `seguranca`.`usuario` (`login` ASC);

-- -----------------------------------------------------
-- Table `seguranca`.`grupo_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguranca`.`grupo_usuario` ;

CREATE TABLE IF NOT EXISTS `seguranca`.`grupo_usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `seguranca`.`modulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguranca`.`modulo` ;

CREATE TABLE IF NOT EXISTS `seguranca`.`modulo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `link` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `seguranca`.`usuario_grupo_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguranca`.`usuario_grupo_usuario` ;

CREATE TABLE IF NOT EXISTS `seguranca`.`usuario_grupo_usuario` (
  `usuario_id` INT NOT NULL,
  `grupo_usuario_id` INT NOT NULL,
  PRIMARY KEY (`usuario_id`, `grupo_usuario_id`),
  CONSTRAINT `fk_usuario_has_grupo_usuario_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `seguranca`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_grupo_usuario_grupo_usuario1`
    FOREIGN KEY (`grupo_usuario_id`)
    REFERENCES `seguranca`.`grupo_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_has_grupo_usuario_grupo_usuario1_idx` ON `seguranca`.`usuario_grupo_usuario` (`grupo_usuario_id` ASC);

CREATE INDEX `fk_usuario_has_grupo_usuario_usuario1_idx` ON `seguranca`.`usuario_grupo_usuario` (`usuario_id` ASC);


-- -----------------------------------------------------
-- Table `seguranca`.`grupo_usuario_modulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguranca`.`grupo_usuario_modulo` ;

CREATE TABLE IF NOT EXISTS `seguranca`.`grupo_usuario_modulo` (
  `grupo_usuario_id` INT NOT NULL,
  `modulo_id` INT NOT NULL,
  PRIMARY KEY (`grupo_usuario_id`, `modulo_id`),
  CONSTRAINT `fk_grupo_usuario_has_modulo_grupo_usuario1`
    FOREIGN KEY (`grupo_usuario_id`)
    REFERENCES `seguranca`.`grupo_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_usuario_has_modulo_modulo1`
    FOREIGN KEY (`modulo_id`)
    REFERENCES `seguranca`.`modulo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_grupo_usuario_has_modulo_modulo1_idx` ON `seguranca`.`grupo_usuario_modulo` (`modulo_id` ASC);

CREATE INDEX `fk_grupo_usuario_has_modulo_grupo_usuario1_idx` ON `seguranca`.`grupo_usuario_modulo` (`grupo_usuario_id` ASC);


-- -----------------------------------------------------
-- Table `seguranca`.`funcao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguranca`.`funcao` ;

CREATE TABLE IF NOT EXISTS `seguranca`.`funcao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `link` VARCHAR(100) NULL,
  `modulo_id` INT NOT NULL,
  PRIMARY KEY (`id`, `modulo_id`),
  CONSTRAINT `fk_funcao_modulo1`
    FOREIGN KEY (`modulo_id`)
    REFERENCES `seguranca`.`modulo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_funcao_modulo1_idx` ON `seguranca`.`funcao` (`modulo_id` ASC);


-- -----------------------------------------------------
-- Table `seguranca`.`grupo_usuario_funcao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seguranca`.`grupo_usuario_funcao` ;

CREATE TABLE IF NOT EXISTS `seguranca`.`grupo_usuario_funcao` (
  `grupo_usuario_id` INT NOT NULL,
  `funcao_id` INT NOT NULL,
  PRIMARY KEY (`grupo_usuario_id`, `funcao_id`),
  CONSTRAINT `fk_grupo_usuario_has_funcao_grupo_usuario1`
    FOREIGN KEY (`grupo_usuario_id`)
    REFERENCES `seguranca`.`grupo_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_usuario_has_funcao_funcao1`
    FOREIGN KEY (`funcao_id`)
    REFERENCES `seguranca`.`funcao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_grupo_usuario_has_funcao_funcao1_idx` ON `seguranca`.`grupo_usuario_funcao` (`funcao_id` ASC);

CREATE INDEX `fk_grupo_usuario_has_funcao_grupo_usuario1_idx` ON `seguranca`.`grupo_usuario_funcao` (`grupo_usuario_id` ASC);

-- -----------------------------------------------------
-- Schema contato
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `contato` DEFAULT CHARACTER SET utf8 ;
GRANT ALL PRIVILEGES ON contato.* TO 'admin'@'%';
USE `contato` ;

-- -----------------------------------------------------
-- Table `contato`.`telefone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contato`.`telefone` ;

CREATE TABLE IF NOT EXISTS `contato`.`telefone` (
  `ddd` INT NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `label` VARCHAR(45) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`ddd`, `usuario_id`),
  CONSTRAINT `fk_telefone_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `seguranca`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_telefone_usuario1_idx` ON `contato`.`telefone` (`usuario_id` ASC);

CREATE INDEX `ix_ddd` ON `contato`.`telefone` (`ddd` ASC);

CREATE INDEX `ix_telefone` ON `contato`.`telefone` (`telefone` ASC);

-- -----------------------------------------------------
-- Table `contato`.`mail_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contato`.`mail_list` ;

CREATE TABLE IF NOT EXISTS `contato`.`mail_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(80) NOT NULL,
  `celular` VARCHAR(14) NULL,
  `data_envio` DATETIME NULL,
  `qde_tentativas` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Schema endereco
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `endereco` DEFAULT CHARACTER SET utf8 ;
GRANT ALL PRIVILEGES ON endereco.* TO 'admin'@'%';
USE `endereco` ;

-- -----------------------------------------------------
-- Table `endereco`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `endereco`.`endereco` ;

CREATE TABLE IF NOT EXISTS `endereco`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `endereco` VARCHAR(80) NOT NULL,
  `numero` VARCHAR(6) NULL,
  `complemento` VARCHAR(60) NULL,
  `bairro` VARCHAR(45) NULL,
  `cep` VARCHAR(10) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(2) NULL,
  `pais` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE INDEX `ix_bairro` ON `endereco`.`endereco` (`bairro` ASC);

CREATE INDEX `ix_cidade` ON `endereco`.`endereco` (`cidade` ASC);

CREATE INDEX `ix_estado` ON `endereco`.`endereco` (`estado` ASC);

CREATE INDEX `ix_cep` ON `endereco`.`endereco` (`cep` ASC);

-- -----------------------------------------------------
-- Schema cliente
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cliente` DEFAULT CHARACTER SET utf8 ;
GRANT ALL PRIVILEGES ON cliente.* TO 'admin'@'%';
USE `cliente` ;

-- -----------------------------------------------------
-- Table `cliente`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cliente`.`cliente` ;

CREATE TABLE IF NOT EXISTS `cliente`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(14) NULL,
  `cpf` VARCHAR(14) NULL,
  `rg` VARCHAR(12) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`, `usuario_id`, `nome`),
  CONSTRAINT `fk_cliente_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `seguranca`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_cliente_usuario1_idx` ON `cliente`.`cliente` (`usuario_id` ASC);

CREATE INDEX `ix_nome_cliente` ON `cliente`.`cliente` (`nome` ASC);

CREATE INDEX `ix_cpf_cliente` ON `cliente`.`cliente` (`cpf` ASC);

CREATE INDEX `ix_cnpj_cliente` ON `cliente`.`cliente` (`cnpj` ASC);

-- -----------------------------------------------------
-- Table `cliente`.`cliente_endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cliente`.`cliente_endereco` ;

CREATE TABLE IF NOT EXISTS `cliente`.`cliente_endereco` (
  `cliente_id` INT NOT NULL,
  `endereco_id` INT NOT NULL,
  PRIMARY KEY (`cliente_id`, `endereco_id`),
  CONSTRAINT `fk_cliente_has_endereco_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `cliente`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_has_endereco_endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `endereco`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_cliente_has_endereco_endereco1_idx` ON `cliente`.`cliente_endereco` (`endereco_id` ASC);

CREATE INDEX `fk_cliente_has_endereco_cliente1_idx` ON `cliente`.`cliente_endereco` (`cliente_id` ASC);

-- -----------------------------------------------------
-- Schema produto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `produto` DEFAULT CHARACTER SET utf8 ;
GRANT ALL PRIVILEGES ON produto.* TO 'admin'@'%';
USE `produto` ;

-- -----------------------------------------------------
-- Table `produto`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produto`.`categoria` ;

CREATE TABLE IF NOT EXISTS `produto`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `produto`.`produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produto`.`produto` ;

CREATE TABLE IF NOT EXISTS `produto`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(200) NULL,
  `marca` VARCHAR(45) NULL,
  `unidade` VARCHAR(45) NOT NULL,
  `valor_unitario` DOUBLE NOT NULL,
  `peso_liquido` DOUBLE NULL,
  `volume` DOUBLE NULL,
  `codigo_barras` VARCHAR(60) NULL,
  `imagem` VARCHAR(100) NULL,
  `ponto_reposicao` INT NULL,
  `preco_custo` DOUBLE NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`id`, `categoria_id`),
  CONSTRAINT `fk_produto_categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `produto`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_produto_categoria1_idx` ON `produto`.`produto` (`categoria_id` ASC);

CREATE INDEX `ix_nome_produto` ON `produto`.`produto` (`nome` ASC);

CREATE INDEX `ix_marca_produto` ON `produto`.`produto` (`marca` ASC);

-- -----------------------------------------------------
-- Table `produto`.`fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produto`.`fornecedor` ;

CREATE TABLE IF NOT EXISTS `produto`.`fornecedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(45) NULL,
  `nome_fantasia` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(14) NULL,
  `cpf` VARCHAR(14) NULL,
  `endereco` VARCHAR(45) NULL,
  `numero` VARCHAR(6) NULL,
  `complemento` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cep` VARCHAR(10) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(2) NULL,
  `telafone1` VARCHAR(20) NULL,
  `telefone2` VARCHAR(20) NULL,
  `email` VARCHAR(45) NULL,
  `contato` VARCHAR(45) NULL,
  `funcao_contato` VARCHAR(45) NULL,
  `endereco_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`, `endereco_id`, `usuario_id`),
  CONSTRAINT `fk_fornecedor_endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `endereco`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fornecedor_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `seguranca`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_fornecedor_endereco1_idx` ON `produto`.`fornecedor` (`endereco_id` ASC);

CREATE INDEX `fk_fornecedor_usuario1_idx` ON `produto`.`fornecedor` (`usuario_id` ASC);

CREATE INDEX `ix_nome_fornecedor` ON `produto`.`fornecedor` (`nome_fantasia` ASC);

CREATE INDEX `ix_bairro_fornecedor` ON `produto`.`fornecedor` (`bairro` ASC);

CREATE INDEX `ix_cep_fornecedor` ON `produto`.`fornecedor` (`cep` ASC);

CREATE INDEX `ix_cidade_fornecedor` ON `produto`.`fornecedor` (`cidade` ASC);

CREATE INDEX `ix_estado_fornecedor` ON `produto`.`fornecedor` (`estado` ASC);

-- -----------------------------------------------------
-- Table `produto`.`produto_fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produto`.`produto_fornecedor` ;

CREATE TABLE IF NOT EXISTS `produto`.`produto_fornecedor` (
  `produto_id` INT NOT NULL,
  `fornecedor_id` INT NOT NULL,
  PRIMARY KEY (`produto_id`, `fornecedor_id`),
  CONSTRAINT `fk_produto_has_fornecedor_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `produto`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_fornecedor_fornecedor1`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `produto`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_produto_has_fornecedor_fornecedor1_idx` ON `produto`.`produto_fornecedor` (`fornecedor_id` ASC);

CREATE INDEX `fk_produto_has_fornecedor_produto1_idx` ON `produto`.`produto_fornecedor` (`produto_id` ASC);

-- -----------------------------------------------------
-- Table `produto`.`foto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produto`.`foto` ;

CREATE TABLE IF NOT EXISTS `produto`.`foto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `caminho` VARCHAR(100) NOT NULL,
  `produto_id` INT NOT NULL,
  PRIMARY KEY (`id`, `produto_id`),
  CONSTRAINT `fk_foto_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `produto`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_foto_produto1_idx` ON `produto`.`foto` (`produto_id` ASC);

-- -----------------------------------------------------
-- Table `produto`.`promocao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produto`.`promocao` ;

CREATE TABLE IF NOT EXISTS `produto`.`promocao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(100) NULL,
  `data_inicio` DATETIME NULL,
  `data_fim` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `produto`.`produto_promocao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produto`.`produto_promocao` ;

CREATE TABLE IF NOT EXISTS `produto`.`produto_promocao` (
  `produto_id` INT NOT NULL,
  `promocao_id` INT NOT NULL,
  `desconto` INT NOT NULL,
  PRIMARY KEY (`produto_id`, `promocao_id`),
  CONSTRAINT `fk_produto_has_promocao_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `produto`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_promocao_promocao1`
    FOREIGN KEY (`promocao_id`)
    REFERENCES `produto`.`promocao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_produto_has_promocao_promocao1_idx` ON `produto`.`produto_promocao` (`promocao_id` ASC);

CREATE INDEX `fk_produto_has_promocao_produto1_idx` ON `produto`.`produto_promocao` (`produto_id` ASC);

-- -----------------------------------------------------
-- Schema loja
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `loja` DEFAULT CHARACTER SET utf8 ;
GRANT ALL PRIVILEGES ON loja.* TO 'admin'@'%';
USE `loja` ;

-- -----------------------------------------------------
-- Table `loja`.`forma_pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `loja`.`forma_pagamento` ;

CREATE TABLE IF NOT EXISTS `loja`.`forma_pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `loja`.`status_pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `loja`.`status_pedido` ;

CREATE TABLE IF NOT EXISTS `loja`.`status_pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `loja`.`vendedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `loja`.`vendedor` ;

CREATE TABLE IF NOT EXISTS `loja`.`vendedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `rg` VARCHAR(12) NULL,
  `endereco_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`, `endereco_id`, `usuario_id`),
  CONSTRAINT `fk_vendedor_endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `endereco`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vendedor_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `seguranca`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_vendedor_endereco1_idx` ON `loja`.`vendedor` (`endereco_id` ASC);

CREATE INDEX `fk_vendedor_usuario1_idx` ON `loja`.`vendedor` (`usuario_id` ASC);

CREATE INDEX `ix_nome` ON `loja`.`vendedor` (`nome` ASC);

CREATE INDEX `ix_cpf` ON `loja`.`vendedor` (`cpf` ASC);

-- -----------------------------------------------------
-- Table `loja`.`pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `loja`.`pedido` ;

CREATE TABLE IF NOT EXISTS `loja`.`pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `qde_itens` INT NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  `valor_frete` DOUBLE NULL,
  `forma_pagamento_id` INT NOT NULL,
  `status_pedido_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `vendedor_id` INT NOT NULL,
  `endereco_id` INT NOT NULL,
  PRIMARY KEY (`id`, `forma_pagamento_id`, `status_pedido_id`, `cliente_id`, `vendedor_id`, `endereco_id`),
  CONSTRAINT `fk_pedido_forma_pagamento`
    FOREIGN KEY (`forma_pagamento_id`)
    REFERENCES `loja`.`forma_pagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_status_pedido1`
    FOREIGN KEY (`status_pedido_id`)
    REFERENCES `loja`.`status_pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `cliente`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_vendedor1`
    FOREIGN KEY (`vendedor_id`)
    REFERENCES `loja`.`vendedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_cliente_endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `cliente`.`cliente_endereco` (`cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_pedido_forma_pagamento_idx` ON `loja`.`pedido` (`forma_pagamento_id` ASC);

CREATE INDEX `fk_pedido_status_pedido1_idx` ON `loja`.`pedido` (`status_pedido_id` ASC);

CREATE INDEX `fk_pedido_cliente1_idx` ON `loja`.`pedido` (`cliente_id` ASC);

CREATE INDEX `fk_pedido_vendedor1_idx` ON `loja`.`pedido` (`vendedor_id` ASC);

CREATE INDEX `fk_pedido_cliente_endereco1_idx` ON `loja`.`pedido` (`endereco_id` ASC);

CREATE INDEX `ix_data_pedido` ON `loja`.`pedido` (`data` ASC);


-- -----------------------------------------------------
-- Table `loja`.`item_pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `loja`.`item_pedido` ;

CREATE TABLE IF NOT EXISTS `loja`.`item_pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` DOUBLE NULL,
  `valor` DOUBLE NULL,
  `desconto` DOUBLE NULL,
  `pedido_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  PRIMARY KEY (`id`, `pedido_id`, `produto_id`),
  CONSTRAINT `fk_item_pedido_pedido1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `loja`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_pedido_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `produto`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_item_pedido_pedido1_idx` ON `loja`.`item_pedido` (`pedido_id` ASC);

CREATE INDEX `fk_item_pedido_produto1_idx` ON `loja`.`item_pedido` (`produto_id` ASC);

-- -----------------------------------------------------
-- Table `loja`.`propaganda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `loja`.`propaganda` ;

CREATE TABLE IF NOT EXISTS `loja`.`propaganda` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `imagem` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `loja`.`propaganda_mail_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `loja`.`propaganda_mail_list` ;

CREATE TABLE IF NOT EXISTS `loja`.`propaganda_mail_list` (
  `propaganda_id` INT NOT NULL,
  `mail_list_id` INT NOT NULL,
  PRIMARY KEY (`propaganda_id`, `mail_list_id`),
  CONSTRAINT `fk_propaganda_has_mail_list_propaganda1`
    FOREIGN KEY (`propaganda_id`)
    REFERENCES `loja`.`propaganda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_propaganda_has_mail_list_mail_list1`
    FOREIGN KEY (`mail_list_id`)
    REFERENCES `contato`.`mail_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_propaganda_has_mail_list_mail_list1_idx` ON `loja`.`propaganda_mail_list` (`mail_list_id` ASC);

CREATE INDEX `fk_propaganda_has_mail_list_propaganda1_idx` ON `loja`.`propaganda_mail_list` (`propaganda_id` ASC);

-- -----------------------------------------------------
-- Table `loja`.`duvida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `loja`.`duvida` ;

CREATE TABLE IF NOT EXISTS `loja`.`duvida` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pergunta` VARCHAR(200) NOT NULL,
  `resposta` VARCHAR(500) NULL,
  `qde_acesso` INT NULL,
  `data_cadastro` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;