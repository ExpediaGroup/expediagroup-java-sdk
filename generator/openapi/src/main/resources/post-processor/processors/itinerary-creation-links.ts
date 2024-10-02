import * as fs from 'node:fs'
import { Edit, Lang, NapiConfig, parse, SgNode } from '@ast-grep/napi'
import { PathOrFileDescriptor } from 'fs'
import * as yaml from 'yaml'

function process (filePath: PathOrFileDescriptor): void {
  const source = fs.readFileSync(filePath, 'utf-8')
  const ast = parse(Lang.Kotlin, source)
  const root = ast.root()

  const edits = [retrieve, resume, completePaymentSession, cancel].flatMap((func) => func(root))
  const newSource = root.commitEdits(edits)
  fs.writeFileSync(filePath, newSource)
}

function readRule (ruleName: string): NapiConfig {
  const rule = fs.readFileSync(`./rules/itinerary-creation-links/${ruleName}.yaml`, 'utf-8')
  return yaml.parse(rule)
}

function retrieve (root: SgNode): Edit[] {
  const config = readRule('retrieve')

  return root.findAll(config).map((node) => {
    return node.replace("GetReservationByItineraryIdOperationLink")
  })
}

function resume (root: SgNode): Edit[] {
    const config = readRule('resume')

    return root.findAll(config).map((node) => {
        return node.replace("PutResumeBookingOperationLink")
    })
}

function completePaymentSession (root: SgNode): Edit[] {
    const config = readRule('complete-payment-session')

    return root.findAll(config).map((node) => {
        return node.replace("PutCompletePaymentSessionOperationLink")
    })
}

function cancel (root: SgNode): Edit[] {
    const config = readRule('cancel')

    return root.findAll(config).map((node) => {
        return node.replace("DeleteHeldBookingOperationLink")
    })
}

export { process as processItineraryCreationLinks }