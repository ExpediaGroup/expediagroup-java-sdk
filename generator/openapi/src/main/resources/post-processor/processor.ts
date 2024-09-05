import { processGetLodgingListingsOperationParams } from './processors/get-lodging-listings-operation-params'
import { processGetLodgingQuotesOperationParams } from "./processors/get-lodging-quotes-operation-params";
import { processTraderDetailsInner } from './processors/trader-details-inner'
import * as path from 'path'

const args = process.argv.slice(2)
const filePath = args[0]
const fileName = path.parse(filePath).name

switch (fileName) {
    case 'GetLodgingListingsOperationParams':
        processGetLodgingListingsOperationParams(filePath)
        break
    case 'GetLodgingQuotesOperationParams':
        processGetLodgingQuotesOperationParams(filePath)
        break
    case 'TraderDetailsInner':
        processTraderDetailsInner(filePath)
        break
}
