import * as path from 'path';
import DummyProcessor from './processors/dummy-processor';

const args = process.argv.slice(2);
const filePath = args[0];
const fileName = path.parse(filePath).name;

switch (fileName) {
  case 'ExemplarClient':
    new DummyProcessor().process(filePath);
    break;
  default:
    break;
}
