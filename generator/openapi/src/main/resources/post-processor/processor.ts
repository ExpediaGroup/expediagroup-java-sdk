import { processTraderDetailsInner } from './processors/trader-details-inner'
import * as path from 'path'

const args = process.argv.slice(2)
const filePath = args[0]
const fileName = path.parse(filePath).name

switch (fileName) {
  case 'TraderDetailsInner':
    processTraderDetailsInner(filePath)
    break
}
