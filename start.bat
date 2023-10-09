@echo off

cd generator
echo "Starting Generator Service..."
mvn -q clean spring-boot:run
cd ..

cd ../validator
echo "Starting Validator Service..."
mvn -q clean spring-boot:run 
cd ..

cd ../gateway
echo "Starting Gateway Service..."
mvn -q clean spring-boot:run 
cd ..

cd ../frontend
echo "Starting Frontend Service..."
npm install &
npm start