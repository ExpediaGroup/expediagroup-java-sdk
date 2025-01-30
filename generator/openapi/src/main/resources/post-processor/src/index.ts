import * as path from 'path';
import DummyProcessor from './processors/dummy-processor';

const args = process.argv.slice(2);
const filePath = args[0];
const fileName = path.parse(filePath).name;

switch (fileName) {
  default:
    break;
}
