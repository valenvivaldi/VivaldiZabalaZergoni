CREATE USER vendedor1 identified by  'contrasena1' ;
CREATE USER vendedor2 identified by  'contrasena2' ;
CREATE USER administrador identified by 'contrasena3' ;

GRANT INSERT ON TABLE Cliente TO vendedor1 ;

GRANT DELETE  ON TABLE Factura TO vendedor2 ;
GRANT SELECT ON TABLE Producto TO vendedor2 ;

GRANT update ON TABLE Producto TO administrador with grant option;

GRANT delete on table ejercicio1p1.Cliente TO PUBLIC;


FLush privileges;
