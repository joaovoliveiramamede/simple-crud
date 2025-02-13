db.createUser({
    user: 'simplecrudroot',
    pwd: 'simplecrudpass',
    roles: [
      {
        role: 'readWrite',
        db: 'simplecrudusers'
      }
    ]
  });
  
  db = db.getSiblingDB('simplecrudusers'); // muda para o banco de dados especificado
  db.createCollection('sample_collection'); // Cria uma coleção de exemplo no banco de dados
  